package view.console.commands;

import view.console.components.Screen;

public class ActionCommand implements MenuCommand
{
    private final Runnable action;
    private final Screen currentScreen;

    public ActionCommand(Runnable action, Screen currentScreen)
    {
        this.action = action;
        this.currentScreen = currentScreen;
    }

    @Override
    public Screen execute()
    {
        action.run();
        return currentScreen;
    }
}