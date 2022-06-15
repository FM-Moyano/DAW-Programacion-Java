package contact_list;

/**
 * 
 * 
 * @author fmmoy
 *
    Un contacto está definido por:
  • Nombre. Será válido cuando no esté vacío y no haya otro con el mismo nombre.
  • Teléfono. Será válido si está compuesto por nueve dígitos, el primero empieza por 6, 7 ó 9.
  • Dirección. No se valida, puede estar vacía.
  • Correo electrónico. Será válido si tiene una sola @ (en medio) y al menos un punto
  (después de la @).
 *
 */

public class Contact {
  
  private String name;
  private String phone;
  private String address;
  private String email;
  
  Contact(String name, String phone, String email) throws InvalidAddressException, InvalidPhoneException, InvalidMailException{
    this(name, phone, email, null);
  }
  
  Contact(String name, String phone, String email, String address) throws InvalidAddressException, InvalidPhoneException, InvalidMailException{
    this.name = name;
    this.setPhone(phone);
    this.setEmail(email);
    this.setAddress(address);
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) throws InvalidPhoneException {
    if(!phone.matches("[679]\\d{8}")) {
      throw new InvalidPhoneException("El número no es correcto");
    }
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) throws InvalidAddressException {
    if(address.equals("")) {
      throw new InvalidAddressException("La direccion no es válida");
    }
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) throws InvalidMailException {
    if(!email.matches("[A-Za-z0-9+_.-]+@(.+)$")) { // (.+)@(.+[\.].+)
      throw new InvalidMailException("Mail invalido");
    }
    this.email = email;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "\n-------------- \nNombre: " + name + "\nTelefono: " + phone + "\nDireccion: " + address + "\nEmail: "
        + email + "\n";
  }
  
  
}
