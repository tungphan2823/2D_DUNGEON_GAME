package utilz;

import main.game;

public class movingStep {
    public static class UI{
        public static class Buttons{
            public static final int BUTTON_WIDTH_D = 140;
            public static final int BUTTON_HEIGHT_D=56;
            public static final int BUTTON_WIDTH=(int)(BUTTON_WIDTH_D*game.SCALE);
            public static final int BUTTON_HEIGHT=(int)(BUTTON_HEIGHT_D*game.SCALE);

        }
    }
    public static class directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT= 2;
        public static final int DOWN= 3;
    };
    public static class playerMovingStep{
        public static final int STAND = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int CROUCH= 3;
        public static final int ATTACK = 4;

        public static int getNumbers(int action){
            switch(action){
                case RUNNING:
                    return 4;
                case STAND:
                    return 3;
                case JUMP:
                    return 3;
                case CROUCH:
                    return 2;
                case ATTACK:
                    return 5;
                default:
                return 1;
            }
        }
    }

}
