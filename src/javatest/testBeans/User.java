/**
 *
 */
package javatest.testBeans;

/**
 * @author darekar
 */
public class User {

    private int userid;
    private String name;
    private String address;

    public User(int userid, String name, String password) {
        super();
        this.userid = userid;
        this.name = name;
        this.address = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return address;
    }

    public void setPassword(String password) {
        this.address = password;
    }
}
