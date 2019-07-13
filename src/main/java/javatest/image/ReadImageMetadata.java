package javatest.image;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;

public class ReadImageMetadata {

    public static void main(String[] args) throws ImageProcessingException, MetadataException, IOException {

	File file = new File(
		"C:\\DDrive\\ML_Workspace\\logo_detection\\logo_data\\test\\a3a81f65-5334-4e06-812e-3bd60c5d7a87.jpg");
        Metadata metadata = ImageMetadataReader.readMetadata(file);

        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.format("[%s] - %s = %s \n",
                    directory.getName(), tag.getTagName(), tag.getDescription());
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }

        // Metadata metadata = ImageMetadataReader.readMetadata(file);
        //
        // Iterator<Directory> i = metadata.getDirectoryIterator();
        //
        // while (i.hasNext()) {
        // Directory directory = i.next();
        // Iterator<Tag> tagIterator = directory.getTagIterator();
        // while (tagIterator.hasNext()) {
        // Tag tag = tagIterator.next();
        // System.out.format("[%s] - %s = %s \n",
        // directory.getName(), tag.getTagName(), tag.getDescription());
        // }
        // if (directory.hasErrors()) {
        // Iterator<String> errIterator = directory.getErrors();
        // while (errIterator.hasNext()) {
        // String error = errIterator.next();
        // System.err.format("ERROR: %s", error);
        // }
        // }
        // }
    }

}
