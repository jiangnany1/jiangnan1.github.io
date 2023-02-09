package JAVA;

public class Mouse01 {
    public static void main(String[] args) {
        /*
         * 1、先创建迷宫，用二维数组表示 int[][] map = new[8][7]
         * 2、先规定 map数组的元素值： 0 表示可以走， 1表示障碍物
         *
         */
        // 创建地图大体结构
        int[][] map = new int[8][7];
        // 将最上面一行和最下面一行全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 将最右面一列和最左面一列全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1; // 每个一维数组的第一个元素设置为1
            map[i][6] = 1; // 每个以为数组的第7个元素设置为1
        }
        map[3][1] = 1;// 竖障碍
        map[3][2] = 1;

        // 输出当前的地图(测试查看)
        System.out.println("——————当前地图情况——————");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println(); // 控制换行
        }

        // 使用finWay给老鼠找路
        Mouse l = new Mouse();
        l.findWay(map, 1, 1);
        // 查看结果
        int step = 0;
        System.out.println("找路的结果：");
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 2) {
                    step++;
                }
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("需要" + (step - 1) + "步");
    }
}

class Mouse {
    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {// 说明已经找到
            return true;
        } else {
            if (map[i][j] == 0) {// 当前这个位置0，说明可以走
                // 假定可以走通
                map[i][j] = 2;
                // 使用策略，来确定该位置是否真的可以走通
                if (findWay(map, i + 1, j)) { // 先走下
                    return true;
                } else if (findWay(map, i, j + 1)) { // 右
                    return true;
                } else if (findWay(map, i - 1, j)) { // 往上
                    return true;
                } else if (findWay(map, i, j - 1)) { // 往下
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // map[i][j] = 1,2,3
                return false;

            }
        }

    }
}