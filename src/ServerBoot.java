import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.function.Function;

public class ServerBoot {
private ServerSocketChannel server;
    public void bootstrap() throws IOException {

        this.server = ServerSocketChannel
                .open()
                .bind(new InetSocketAddress("localhost", 8080));
    }
    private ByteBuffer getBuffer() {
    return ByteBuffer.allocate(2048);
    }
    public void close() throws IOException {
        server.close();
    }
    public void echoHandler(CallbackFunc call) throws IOException {
        ByteBuffer buffer = getBuffer();
        SocketChannel channel = server.accept();
        channel.read(buffer);
        buffer.flip();
        channel.write(buffer);
        call.callback();
    }
}
