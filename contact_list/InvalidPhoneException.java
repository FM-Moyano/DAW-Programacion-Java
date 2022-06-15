package contact_list;

@SuppressWarnings("serial")
public class InvalidPhoneException extends Exception{
  public InvalidPhoneException(String string) {
    super(string);
  }
}
