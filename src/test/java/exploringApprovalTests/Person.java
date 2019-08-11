package exploringApprovalTests;

public class Person
{
  private final String  firstName;
  private final String  lastName;
  private final boolean isNotMale;
  private final int     age;
  public Person(String firstName, String lastName, boolean isNotMale, int age)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isNotMale = isNotMale;
    this.age = age;
  }
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public boolean isNotMale()
  {
    return isNotMale;
  }
  public int getAge()
  {
    return age;
  }
}