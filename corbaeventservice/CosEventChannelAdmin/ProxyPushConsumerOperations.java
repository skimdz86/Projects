package CosEventChannelAdmin;


/**
* CosEventChannelAdmin/ProxyPushConsumerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public interface ProxyPushConsumerOperations  extends CosEventComm.PushConsumerOperations
{
  void connect_push_supplier (CosEventComm.PushSupplier push_supplier) throws CosEventChannelAdmin.AlreadyConnected;
} // interface ProxyPushConsumerOperations
