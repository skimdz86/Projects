package CosEventChannelAdmin;


/**
* CosEventChannelAdmin/AlreadyConnected.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public final class AlreadyConnected extends org.omg.CORBA.UserException
{

  public AlreadyConnected ()
  {
    super(AlreadyConnectedHelper.id());
  } // ctor


  public AlreadyConnected (String $reason)
  {
    super(AlreadyConnectedHelper.id() + "  " + $reason);
  } // ctor

} // class AlreadyConnected
