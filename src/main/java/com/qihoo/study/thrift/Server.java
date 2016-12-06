package com.qihoo.study.thrift;

import com.qihoo.study.thrift.protocol.TTraceProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.qihoo.study.thrift.protocol.TTraceProcessor;

public class Server {
	private static final int SERVERPORT = 9100;
	private static final int TIMEOUT = 60000000;

	public static void main(String[] args) throws TTransportException {
		Calculator.Processor<CalculatorImpl> processor = new Calculator.Processor<CalculatorImpl>(new CalculatorImpl());
		TServerTransport serverTransport = new TServerSocket(SERVERPORT, TIMEOUT);
			
		TProtocolFactory factory = new TTraceProtocol.Factory(new TTupleProtocol.Factory());

		TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).protocolFactory(factory).processor(new TTraceProcessor(processor)));
//		TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(new TTraceProcessor(processor)));

		System.out.println("Starting db service......");
		server.serve();
		System.out.println("dsfdsf");
	}
}
