package view.console.commands;

import view.console.components.Screen;

import java.util.function.Supplier;

public class SwitchScreenCommand implements MenuCommand
{
    private final Supplier<Screen> screenSupplier;

    public SwitchScreenCommand(Supplier<Screen> screenSupplier)
    {
        this.screenSupplier = screenSupplier;
    }

    @Override
    public Screen execute()
    {
        return screenSupplier.get();
    }
}
