package CosEventComm;

/**
* CosEventComm/PushConsumerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventComm.idl
* martedì 16 marzo 2010 10.44.20 CET
*/

public final class PushConsumerHolder implements org.omg.CORBA.portable.Streamable
{
  public CosEventComm.PushConsumer value = null;

  public PushConsumerHolder ()
  {
  }

  public PushConsumerHolder (CosEventComm.PushConsumer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosEventComm.PushConsumerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosEventComm.PushConsumerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosEventComm.PushConsumerHelper.type ();
  }

}
