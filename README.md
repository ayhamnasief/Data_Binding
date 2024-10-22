### Data Binding (Library of JetPack) 
Allows to bind UI components in your layout to data sources in your app using a declarative format rather than programmatically. 
Data binding is the process of integrating views in an XML layout with data objects.
The data binding library is responsible for generating the classes required for this procedure Using data binding and binding object will be created.
Using the data binding, a binding object will be created that contains a reference to each view of a layout So the Android system will not go and search the views by their IDs again and again, It will go to this data binding object and get the reference to each view of the layout.

![image](https://developer.android.com/static/codelabs/android-databinding/img/30a7d03de58070bd.png)

### Example (JAVA)
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

```java
public class Cat extends BaseObservable {
    String catName;

    public Cat() {}

    public Cat(String catName) {
        this.catName = catName;
    }

    @Bindable
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
        notifyPropertyChanged(BR.catName);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="person"
            type="com.example.flamingo_test.Person" />

        <variable
            name="myOnClickButton"
            type="com.example.flamingo_test.MyOnClickButton" />
        <variable
            name="cat"
            type="com.example.flamingo_test.Cat" />
    </data>


    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/cl"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/black"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/tv1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="32dp"
            android:text="Basic Data Binding - Person"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.093"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/tv2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:layout_marginTop="15dp"
            android:text="ID: "
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv1" />

        <TextView
            android:id="@+id/tvPersonId"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="64dp"
            android:text="@{String.valueOf(person.id)}"
            app:layout_constraintBottom_toBottomOf="@+id/tv2"
            app:layout_constraintStart_toEndOf="@+id/tv2"
            app:layout_constraintTop_toTopOf="@+id/tv2"
            app:layout_constraintVertical_bias="0.0" />

        <TextView
            android:id="@+id/tv3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:layout_marginTop="15dp"
            android:text="Name: "
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv2" />

        <TextView
            android:id="@+id/tvPersonName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:text="@{person.name}"
            app:layout_constraintBottom_toBottomOf="@+id/tv3"
            app:layout_constraintStart_toEndOf="@+id/tv3"
            app:layout_constraintTop_toTopOf="@+id/tv3"
            app:layout_constraintVertical_bias="0.0" />

        <TextView
            android:id="@+id/tv4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="Email: "
            android:textColor="@color/white"
            app:layout_constraintEnd_toEndOf="@+id/tv3"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="@+id/tv3"
            app:layout_constraintTop_toBottomOf="@+id/tv3" />

        <TextView
            android:id="@+id/tvPersonEmail"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:text="@{person.email}"
            app:layout_constraintBottom_toBottomOf="@+id/tv4"
            app:layout_constraintStart_toEndOf="@+id/tv4"
            app:layout_constraintTop_toTopOf="@+id/tv4"
            app:layout_constraintVertical_bias="0.0" />

        <View
            android:id="@+id/divider"
            android:layout_width="409dp"
            android:layout_height="1dp"
            android:layout_marginStart="1dp"
            android:layout_marginTop="15dp"
            android:layout_marginEnd="1dp"
            android:background="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv4" />

        <TextView
            android:id="@+id/tv5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="25dp"
            android:text="Handling Click Event - Dog"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/divider" />

        <Button
            android:id="@+id/btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:onClick="@{myOnClickButton::getDogName}"
            android:text="Get Dog Name"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv5" />

        <View
            android:id="@+id/divider2"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="15dp"
            android:background="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/btn" />

        <TextView
            android:id="@+id/tv6"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="Two Way Binding - Cat"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.056"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/divider2" />

        <EditText
            android:id="@+id/etCatName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:ems="10"
            android:hint="Enter Your Name"
            android:inputType="text"
            android:text="@={cat.catName}"
            android:textColor="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv6" />

        <TextView
            android:id="@+id/tvCatName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="@{cat.catName}"
            android:textSize="20sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/etCatName" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

```java
public class MyOnClickButton {
    Context context;

    public MyOnClickButton(Context context) {
        this.context = context;
    }

    public void getDogName(View view){
        Toast.makeText(context, "Roxy", Toast.LENGTH_SHORT).show();
    }
}
```

```java
public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // On Way Binding
        binding.setPerson(new Person(1, "Ayham Nassif", "ayham@gmail.com"));

        // On Click Binding
        binding.setMyOnClickButton(new MyOnClickButton(this));

        // Tow Way Binding
        binding.setCat(new Cat());

    }
}
```

### Example (KOTLIN)
```kotlin
data class Person(var id:Int, var name:String, var email:String)
```

```kotlin
class Cat:BaseObservable() {

    @Bindable
    var catName:String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.catName)
        }
}
```

```kotlin
class MyOnClickButton(val context: Context) {
    fun getDogName(view: View){
        Toast.makeText(context, "Roxy", Toast.LENGTH_LONG).show()
    }
}
```

```kotlin
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.person = Person(1, "Ayham Nassif", "ayham@gmail.com")

        binding.myOnClickButton = MyOnClickButton(this)

        binding.cat = Cat()

    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="person"
            type="com.example.databinding_kotlin.Person" />

        <variable
            name="myOnClickButton"
            type="com.example.databinding_kotlin.MyOnClickButton" />
        <variable
            name="cat"
            type="com.example.databinding_kotlin.Cat" />
    </data>


    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/cl"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/black"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/tv1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="32dp"
            android:text="Basic Data Binding - Person"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.093"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/tv2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:layout_marginTop="15dp"
            android:text="ID: "
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv1" />

        <TextView
            android:id="@+id/tvPersonId"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="64dp"
            android:text="@{String.valueOf(person.id)}"
            app:layout_constraintBottom_toBottomOf="@+id/tv2"
            app:layout_constraintStart_toEndOf="@+id/tv2"
            app:layout_constraintTop_toTopOf="@+id/tv2"
            app:layout_constraintVertical_bias="0.0" />

        <TextView
            android:id="@+id/tv3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:layout_marginTop="15dp"
            android:text="Name: "
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv2" />

        <TextView
            android:id="@+id/tvPersonName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:text="@{person.name}"
            app:layout_constraintBottom_toBottomOf="@+id/tv3"
            app:layout_constraintStart_toEndOf="@+id/tv3"
            app:layout_constraintTop_toTopOf="@+id/tv3"
            app:layout_constraintVertical_bias="0.0" />

        <TextView
            android:id="@+id/tv4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="Email: "
            android:textColor="@color/white"
            app:layout_constraintEnd_toEndOf="@+id/tv3"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="@+id/tv3"
            app:layout_constraintTop_toBottomOf="@+id/tv3" />

        <TextView
            android:id="@+id/tvPersonEmail"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="40dp"
            android:text="@{person.email}"
            app:layout_constraintBottom_toBottomOf="@+id/tv4"
            app:layout_constraintStart_toEndOf="@+id/tv4"
            app:layout_constraintTop_toTopOf="@+id/tv4"
            app:layout_constraintVertical_bias="0.0" />

        <View
            android:id="@+id/divider"
            android:layout_width="409dp"
            android:layout_height="1dp"
            android:layout_marginStart="1dp"
            android:layout_marginTop="15dp"
            android:layout_marginEnd="1dp"
            android:background="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv4" />

        <TextView
            android:id="@+id/tv5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="25dp"
            android:text="Handling Click Event - Dog"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/divider" />

        <Button
            android:id="@+id/btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:onClick="@{myOnClickButton::getDogName}"
            android:text="Get Dog Name"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv5" />

        <View
            android:id="@+id/divider2"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="15dp"
            android:background="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/btn" />

        <TextView
            android:id="@+id/tv6"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="Two Way Binding - Cat"
            android:textColor="@color/white"
            android:textSize="24sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.056"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/divider2" />

        <EditText
            android:id="@+id/etCatName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:ems="10"
            android:hint="Enter Your Name"
            android:inputType="text"
            android:text="@={cat.catName}"
            android:textColor="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tv6" />

        <TextView
            android:id="@+id/tvCatName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="@{cat.catName}"
            android:textSize="20sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/etCatName" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

![Screenshot_20241020_105725](https://github.com/user-attachments/assets/42f25c3a-3f47-4ec1-98bf-42fb4b5671e2)

