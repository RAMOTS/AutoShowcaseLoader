# How to use
## General preparations
0. Have a discord account and server to which you want to invite the bot to
1. Create a new Discord Application under https://discord.com/developers/applications
2. Under the bot tab create a bot and save the bot token as it is important later
3. Also turn (in the same tab) Server Members intent and message content intent on
4. To invite your bot to your server simply go to OAuth2 -> URL Generator and select Bot. Then select (simply for now, later please use only the needed permissions) Administrastor, copy the url below this window and paste it into your browser. Continue with the bot adding process as normal.
5. In Discord go to Settings -> Advanced and turn Developer Mode on
6. When right clicking on a text chanel on the server you joined the bot to, you should now be able to copy a Channel ID. Save it for a logging an Welcome Text Channel as we need it later

You should now have a bot token and two techt channel ids. If this is the case you can continue.

## Editing the code
0. If not already done pull this repo and open it in a ide that works (I used InteliJ IDEA Ultimate 2023.2.5)
1. You will find in the Main.java file a where four Variables are defined. Modify the first one, so that it only contains the bot token
2. For the second variable you can just chosse something to be displayed under the bot, like Playing a minecraft server. The prefix Playing is not able to be changed easily
3. The third variable should be replaced with the Channel ID  of the logging channel, followed by a big L
4. Repeat step 3 for the last variable, but do it this time with the welcome channel id

Your modified code should now look like that:

    private static String botToken = "NzYwMTI1MDA2NDI4MjQxOTUy.X3Hfkw.EjIL6vI9XPHvhp9mmh6XZf7RoMo";
    private static String activity = "with your mom";
    private static Long logID = 1020304050607080901L;
    private static Long welcomeID = 0090037400210805061L;

## Accually running your bot
1. Compile everythin to a runnable .jar file
2. Save the .jar file on the machiene you would like your bot to be run on
3. Make sure the correct Java version is installed (in this case Java 17)
4. Open a terminal and direct it to the file location
5. With `java -jar [filename].jar` you can now run your bot
