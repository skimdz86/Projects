package CosEventChannelAdmin;


/**
* CosEventChannelAdmin/ProxyPullSupplierOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public interface ProxyPullSupplierOperations  extends CosEventComm.PullSupplierOperations
{
  void connect_pull_consumer (CosEventComm.PullConsumer pull_consumer) throws CosEventChannelAdmin.AlreadyConnected;
} // interface ProxyPullSupplierOperations
