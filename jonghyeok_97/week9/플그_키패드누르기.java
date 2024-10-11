package jonghyeok_97.week9;

public class 플그_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Position leftHand = new Position(3, 0);
        Position rightHand = new Position(3, 2);

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                if (number == 1) {
                    leftHand.setPosition(0, 0);
                }
                if (number == 4) {
                    leftHand.setPosition(1, 0);
                }
                if (number == 7) {
                    leftHand.setPosition(2, 0);
                }
            }
            if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                if (number == 3) {
                    rightHand.setPosition(0, 2);
                }
                if (number == 6) {
                    rightHand.setPosition(1, 2);
                }
                if (number == 9) {
                    rightHand.setPosition(2, 2);
                }
            }
            if (number == 2) {
                Position two = new Position(0, 1);
                int leftCount = leftHand.moveCount(two);
                int rightCount = rightHand.moveCount(two);
                if (leftCount == rightCount) {
                    if ("right".equals(hand)) {
                        rightHand.setPosition(0, 1);
                        answer.append("R");
                    }
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftHand.setPosition(0, 1);
                    }
                }
                if (leftCount > rightCount) {
                    answer.append("R");
                    rightHand.setPosition(0, 1);
                }
                if (leftCount < rightCount) {
                    answer.append("L");
                    leftHand.setPosition(0, 1);
                }
            }
            if (number == 5) {
                Position five = new Position(1, 1);
                int leftCount = leftHand.moveCount(five);
                int rightCount = rightHand.moveCount(five);

                if (leftCount == rightCount) {
                    if ("right".equals(hand)) {
                        rightHand.setPosition(1, 1);
                        answer.append("R");
                    }
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftHand.setPosition(1, 1);
                    }
                }
                if (leftCount > rightCount) {
                    answer.append("R");
                    rightHand.setPosition(1, 1);
                }
                if (leftCount < rightCount) {
                    answer.append("L");
                    leftHand.setPosition(1, 1);
                }

            }
            if (number == 8) {
                Position eight = new Position(2, 1);
                int leftCount = leftHand.moveCount(eight);
                int rightCount = rightHand.moveCount(eight);
                if (leftCount == rightCount) {
                    if ("right".equals(hand)) {
                        rightHand.setPosition(2, 1);
                        answer.append("R");
                    }
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftHand.setPosition(2, 1);
                    }
                }
                if (leftCount > rightCount) {
                    answer.append("R");
                    rightHand.setPosition(2, 1);
                }
                if (leftCount < rightCount) {
                    answer.append("L");
                    leftHand.setPosition(2, 1);
                }
            }
            if (number == 0) {
                Position zero = new Position(3, 1);
                int leftCount = leftHand.moveCount(zero);
                int rightCount = rightHand.moveCount(zero);
                if (leftCount == rightCount) {
                    if ("right".equals(hand)) {
                        rightHand.setPosition(3, 1);
                        answer.append("R");
                    }
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftHand.setPosition(3, 1);
                    }
                }
                if (leftCount > rightCount) {
                    answer.append("R");
                    rightHand.setPosition(3, 1);
                }
                if (leftCount < rightCount) {
                    answer.append("L");
                    leftHand.setPosition(3, 1);
                }
            }
        }
        return answer.toString();
    }

    static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setPosition(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int moveCount(Position other) {
            return Math.abs(y - other.y) + Math.abs(x - other.x);
        }

        public String toString() {
            return y + " : " + x;
        }
    }
}
