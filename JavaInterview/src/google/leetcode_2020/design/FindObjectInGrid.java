package google.leetcode_2020.design;

public class FindObjectInGrid {


    public int[] findObjectInGrid() {
        int n = maxBound(true),
                m = maxBound(false);
        int objectRow = findRowOrColumn(true, 0, n - 1);
        int objectColumn = findRowOrColumn(false, 0, m - 1);
        return new int[]{objectRow, objectRow};
    }

    // O(log n)
    private int maxBound(boolean isRow) {
        int low = 0,
                high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Response r = getResponse(isRow ? mid : 0, isRow ? 0 : mid);
            if (r.isError()) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // O(log n)
    private int findRowOrColumn(boolean isRow, int start, int end) {
        int low = start,
                high = end;
        while (low <= high) {
            Response r1 = getResponse(isRow ? low : 0, isRow ? 0 : low);
            Response r2 = getResponse(isRow ? high : 0, isRow ? 0 : high);
            int mid = low + (high - low) / 2;
            switch (r2.code()) {
                case Response.EXACT:
                    return high;
                case Response.SAME:
                    return mid;
                case Response.HOTTER:
                    low = mid;
                    break;
                case Response.COLDER:
                    high = mid;
                    break;
            }
        }
        return -1;
    }


    enum Response {
        HOTTER,  // Moving closer to target
        COLDER,  // Moving farther from target
        SAME,    // Same distance from the target as your previous guess
        EXACT;   // Reached destination

        boolean isError() {
            return false;
        }

//        Response code() {
//            return HOTTER;
//        }
    }

    // Throws an error if 'row' or 'col' is out of bounds
    public Response getResponse(int row, int col) {
        // black box
        return Response.HOTTER;
    }
}
