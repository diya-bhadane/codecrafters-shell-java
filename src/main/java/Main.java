import org.jline.reader.*;
import org.jline.reader.impl.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new StringsCompleter("echo", "exit"))
                .build();

        while (true) {
            String input = reader.readLine("$ ");

            String[] parts = input.split(" ");
            String command = parts[0];

            if (command.equals("exit")) {
                System.exit(0);
            } else if (command.equals("echo")) {
                if (parts.length > 1) {
                    System.out.println(
                        input.substring(input.indexOf(" ") + 1)
                    );
                } else {
                    System.out.println();
                }
            }
        }
    }
}