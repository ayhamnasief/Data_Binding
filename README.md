## Data Binding (Library of JetPack) 
#### Allows to bind UI components in your layout to data sources in your app using a declarative format rather than programmatically. 
#### Data binding is the process of integrating views in an XML layout with data objects.
#### The data binding library is responsible for generating the classes required for this procedure Using data binding and binding object will be created.
#### Using the data binding, a binding object will be created that contains a reference to each view of a layout So the Android system will not go and search the views by their IDs again and again, It will go to this data binding object and get the reference to each view of the layout.

![image](https://developer.android.com/static/codelabs/android-databinding/img/30a7d03de58070bd.png)


```java
public class Person {
    int id;
    String name, email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```
