package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
     public final static class Constants{
         public final static String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW="Server is not accessible for now.";
         public final static String USER_AUTH_ERR="User is not authorized.";
         public final static String BANNED_USER="User is not authorized.";
         public final static String REST_EXP="Access is denied.";

     }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_IS_NOT_ACCESSIBLE_FOR_NOW, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_AUTH_ERR);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_AUTH_ERR, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNED_USER);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNED_USER, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.REST_EXP);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.REST_EXP, cause);
        }
    }
}
