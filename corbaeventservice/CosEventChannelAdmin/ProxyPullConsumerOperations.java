package CosEventChannelAdmin;


/**
* CosEventChannelAdmin/ProxyPullConsumerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosEventChannelAdmin.idl
* martedì 16 marzo 2010 11.29.55 CET
*/

public interface ProxyPullConsumerOperations  extends CosEventComm.PullConsumerOperations
{
  void connect_pull_supplier (CosEventComm.PullSupplier pull_supplier) throws CosEventChannelAdmin.AlreadyConnected, CosEventChannelAdmin.TypeError;
} // interface ProxyPullConsumerOperations
