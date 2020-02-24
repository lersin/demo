package org.onosproject.cli.net;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.net.helloworld.HelloWorldService;

@Command(scope = "onos", name = "hello",
         description = "Hello World Command")
public class HelloWorldCommand extends AbstractShellCommand {

    @Argument(index = 0, name = "world", description = "Hello World",
              required = false, multiValued = false)
    private String world = null;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    private HelloWorldService helloWorldService;

    @Override
    protected void execute() {
        helloWorldService = get(HelloWorldService.class);

        if (world != null) {
            helloWorldService.sayHello(world);
        } else {
            helloWorldService.sayHello("nothing");
        }
    }

}
