package com.misc;

import java.util.List;

public class GasStation {
    public static int canCompleteCircuit(List<Integer> gas, List<Integer> cost) {
        int sIdx = 0;
        int gasLeft = 0;
        int sCount = 0;
        int length = gas.size();

        for (int i = 0; i < length; i++){
            int c = (sIdx + i) % length;
            if (sIdx == length) break;
            gasLeft += gas.get(c) - cost.get(c);
            if (gasLeft >= 0) {
                sCount++;
            }
            else {
                sCount = 0; gasLeft = 0; sIdx++; i = 0;
            }
        }
        return (sCount == length)? sIdx : -1;
    }
}
