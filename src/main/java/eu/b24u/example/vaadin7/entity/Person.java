package eu.b24u.example.vaadin7.entity;

/**
 * Data model describe person
 * 
 * @author bwcmsys
 *
 */
public class Person {

  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public Person() {
    // TODO Auto-generated constructor stub
  }

  String name;
  int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

}
