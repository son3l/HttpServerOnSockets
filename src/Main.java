import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         ServerBoot serv = new ServerBoot();
        try {
            serv.bootstrap();
            serv.echoHandler(serv::close);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}