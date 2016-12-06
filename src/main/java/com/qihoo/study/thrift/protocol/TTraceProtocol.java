package com.qihoo.study.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TMessageType;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolDecorator;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;

public class TTraceProtocol extends TProtocolDecorator {
	/** Used to delimit the traceId from the function name */
	public static final String SEPARATOR = ":";

	public TTraceProtocol(TProtocol protocol) {
		super(protocol);
	}

	public static class Factory implements TProtocolFactory {
		private TProtocolFactory concreteFactory;
		public Factory(TProtocolFactory concreteFactory) {
			this.concreteFactory = concreteFactory;
		}

		public TProtocol getProtocol(TTransport trans) {
			return new TTraceProtocol(concreteFactory.getProtocol(trans));
		}
	}

	public void writeMessageBegin(TMessage tMessage) throws TException {
		if (tMessage.type == TMessageType.CALL || tMessage.type == TMessageType.ONEWAY) {
			super.writeMessageBegin(new TMessage("aa" + SEPARATOR + tMessage.name, tMessage.type, tMessage.seqid));
		} else {
			super.writeMessageBegin(tMessage);
		}
	}
}
