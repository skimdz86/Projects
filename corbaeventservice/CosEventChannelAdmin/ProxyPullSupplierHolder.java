package CosEventChannelAdmin;

/**
* CosEventChannelAdmin/ProxyPullSupplierHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public final class ProxyPullSupplierHolder implements org.omg.CORBA.portable.Streamable
{
  public CosEventChannelAdmin.ProxyPullSupplier value = null;

  public ProxyPullSupplierHolder ()
  {
  }

  public ProxyPullSupplierHolder (CosEventChannelAdmin.ProxyPullSupplier initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosEventChannelAdmin.ProxyPullSupplierHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosEventChannelAdmin.ProxyPullSupplierHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosEventChannelAdmin.ProxyPullSupplierHelper.type ();
  }

}
