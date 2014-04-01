package es.eucm.network.gui;

import java.text.MessageFormat;
import java.util.Map.Entry;

import com.btr.proxy.util.Logger;
import com.btr.proxy.util.Logger.LogBackEnd;
import com.btr.proxy.util.Logger.LogLevel;

import es.eucm.network.JavaRequestHelper;
import es.eucm.network.requests.RequestHelper;
import es.eucm.network.requests.ResourceCallback;

public class NetworkGUI {

	public static void main(String args[]) {

		Logger.setBackend(new ConsoleLogBackend());
		String urlTest = "http://downloads.sourceforge.net/project/e-adventure/stable/update.json";
		RequestHelper requestHelper = new JavaRequestHelper();

		System.out.println("JAVA ENVIRONMENT SETTINGS");
		for (Entry<Object, Object> e : System.getProperties()
				.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}

		requestHelper.url(urlTest).get(new ResourceCallback<Object>() {
			@Override
			public void error(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void success(Object data) {
				System.out.println(data);
				System.out.println("Success!");
				System.out.println("System properties:");
			}
		}, String.class, false);
	}
	
	private static class ConsoleLogBackend implements LogBackEnd {

		@Override
		public void log(Class<?> clazz, LogLevel loglevel, String msg,
				Object... params) {
			System.out.print("["+loglevel.name()+"] ");
			System.out.print(clazz.getCanonicalName() + ": ");
			System.out.println(MessageFormat.format(msg, params));
		}

		@Override
		public boolean isLogginEnabled(LogLevel logLevel) {
			return true;
		}

	}
}
