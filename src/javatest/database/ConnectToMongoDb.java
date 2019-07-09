package javatest.database;

import java.util.Date;
import java.util.regex.Pattern;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ConnectToMongoDb {

    String host = "localhost";
    String databaseName = "testdb";
    String tableName = "user";

    /**** Connect to MongoDB ****/
    // Since 2.10.0, uses MongoClient
    MongoClient mongo = null;
    DB db = null;
    DBCollection table = null;

    public ConnectToMongoDb() {
        //mongo = new MongoClient(host, 27017);
        db = mongo.getDB(databaseName);
        table = db.getCollection(tableName);
    }

    public static void main(final String[] args) {
        final ConnectToMongoDb connnect = new ConnectToMongoDb();
        // connnect.insert();
        // connnect.update();
        connnect.displayAll();
    }

    public void insert() {
        final BasicDBObject document = new BasicDBObject();
        document.put("name", "darekar");
        document.put("age", 30);
        document.put("createdDate", new Date());
        table.insert(document);
    }

    public void update() {
        final BasicDBObject query = new BasicDBObject();
        query.put("name", "darekar");

        final BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "darekar-updated");

        final BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
    }

    public void displayAll() {
        final Pattern searchPattern = Pattern.compile("da");

        final BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", searchPattern);

        final DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}
