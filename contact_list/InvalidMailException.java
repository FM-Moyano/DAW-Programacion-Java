package contact_list;

@SuppressWarnings("serial")
public class InvalidMailException extends Exception {
  public InvalidMailException(String string) {
    super(string);
  }
}
