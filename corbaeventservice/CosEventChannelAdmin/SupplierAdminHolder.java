package CosEventChannelAdmin;

/**
* CosEventChannelAdmin/SupplierAdminHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public final class SupplierAdminHolder implements org.omg.CORBA.portable.Streamable
{
  public CosEventChannelAdmin.SupplierAdmin value = null;

  public SupplierAdminHolder ()
  {
  }

  public SupplierAdminHolder (CosEventChannelAdmin.SupplierAdmin initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosEventChannelAdmin.SupplierAdminHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosEventChannelAdmin.SupplierAdminHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosEventChannelAdmin.SupplierAdminHelper.type ();
  }

}
