package CosEventComm;


/**
* CosEventComm/Disconnected.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventComm.idl
* martedì 16 marzo 2010 10.44.20 CET
*/

public final class Disconnected extends org.omg.CORBA.UserException
{

  public Disconnected ()
  {
    super(DisconnectedHelper.id());
  } // ctor


  public Disconnected (String $reason)
  {
    super(DisconnectedHelper.id() + "  " + $reason);
  } // ctor

} // class Disconnected
