


class Move {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 0, 10);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
         // your implementation here

        moveRobotToX(robot, toX);
        moveRobotToY(robot, toY);
        System.out.println("robot.getX() = " + robot.getX());
        System.out.println("robot.getY() = " + robot.getY());
    }

    private static void moveRobotToX(Robot robot, int toX) {
        var disX = toX - robot.getX();
        Direction reqDir;
        if (disX == 0) {
            return;
        }
        if (disX > 0) {
            reqDir = Direction.RIGHT;
        } else {
            reqDir = Direction.LEFT;
        }

        rotateRobotToRequiredDirection(robot, reqDir);

        while (disX != 0) {
            robot.stepForward();
            if (disX > 0) {
                disX--;
            } else {
                disX++;
            }
        }
    }

    private static void moveRobotToY(Robot robot, int toY) {
        var disY = toY - robot.getY();
        Direction reqDir;
        if (disY == 0) {
            return;
        }
        if (disY > 0) {
            reqDir = Direction.UP;
        } else {
            reqDir = Direction.DOWN;
        }

        rotateRobotToRequiredDirection(robot, reqDir);

        while (disY != 0) {
            robot.stepForward();
            if (disY > 0) {
                disY--;
            } else {
                disY++;
            }
        }
    }


    private static void rotateRobotToRequiredDirection(Robot robot, Direction reqDir) {
        Direction dirLeft = robot.getDirection();
        Direction dirRight = robot.getDirection();
        int left = 0;
        int right = 0;
        while (!dirLeft.equals(reqDir)) {
            dirLeft = dirLeft.turnLeft();
            left++;
        }
        while (!dirRight.equals(reqDir)) {
            dirRight = dirRight.turnRight();
            right++;
        }
        if (left < right) {
            while (left > 0) {
                robot.turnLeft();
                left--;
            }
        } else {
            while (right > 0) {
                robot.turnRight();
                right--;
            }
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        System.out.println("Robot.turnLeft");
        direction = direction.turnLeft();
    }

    public void turnRight() {
        System.out.println("Robot.turnRight");
        direction = direction.turnRight();
    }

    public void stepForward() {
        System.out.println("Robot.stepForward");
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}