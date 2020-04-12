package regex;

public class MyRegex {
    String is255 = "([0-9]|[0-9][0-9]|[01][0-9][0-9]|[02][0-4][0-9]|25[0-5])";
    String pattern = is255 + "." + is255 + "." + is255 + "." + is255;
}
