package CosEventChannelAdmin;


/**
* CosEventChannelAdmin/TypeError.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public final class TypeError extends org.omg.CORBA.UserException
{

  public TypeError ()
  {
    super(TypeErrorHelper.id());
  } // ctor


  public TypeError (String $reason)
  {
    super(TypeErrorHelper.id() + "  " + $reason);
  } // ctor

} // class TypeError
