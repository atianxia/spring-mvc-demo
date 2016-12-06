package com.qihoo.study.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TMessageType;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolDecorator;

public class TTraceProcessor implements TProcessor {

	private TProcessor actualProcessor;

	public TTraceProcessor(TProcessor actualProcessor) {
		super();
		this.actualProcessor = actualProcessor;
	}

	@Override
	public boolean process(TProtocol iprot, TProtocol oprot) throws TException {
		/*
		 * Use the actual underlying protocol (e.g. TBinaryProtocol) to read the
		 * message header. This pulls the message "off the wire", which we'll
		 * deal with at the end of this method.
		 */
		String test = iprot.readString();
		System.out.print(test);
		TMessage message = iprot.readMessageBegin();

		if (message.type != TMessageType.CALL && message.type != TMessageType.ONEWAY) {
			throw new TException("This should not have happened!?");
		}

		// Extract the service name
		int index = message.name.indexOf(TTraceProtocol.SEPARATOR);
		if (index < 0) {
			throw new TException("traceId not found in message name: " + message.name + ".  Did you "
					+ "forget to use a TTraceProtocol in your client?");
		}

		// Create a new TMessage, something that can be consumed by any
		// TProtocol
		String traceId = message.name.substring(0, index);

		System.out.println(traceId);

		// Create a new TMessage, removing the traceId
		TMessage standardMessage = new TMessage(
				message.name.substring(traceId.length() + TTraceProtocol.SEPARATOR.length()), message.type,
				message.seqid);

		// Dispatch processing to the actual processor
		return actualProcessor.process(new StoredMessageProtocol(iprot, standardMessage), oprot);
	}

	/**
	 * Our goal was to work with any protocol. In order to do that, we needed to
	 * allow them to call readMessageBegin() and get a TMessage in exactly the
	 * standard format, without the traceId prepended to TMessage.name.
	 */
	private static class StoredMessageProtocol extends TProtocolDecorator {
		TMessage messageBegin;

		public StoredMessageProtocol(TProtocol protocol, TMessage messageBegin) {
			super(protocol);
			this.messageBegin = messageBegin;
		}

		@Override
		public TMessage readMessageBegin() throws TException {
			return messageBegin;
		}
	}

}
