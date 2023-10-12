
package com.wkr.maxto50;

import com.wkr.common.Utils;

import java.util.ArrayList;
import java.util.List;

/************************************************************************
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 * number of rows like this: (you may want to display this pattern in a fixed
 * font for better legibility)
 * P       A       H       N
 * A   P   L   S   I   I   G
 * Y       I       R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given
 * a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 ************************************************************************/

public class C06ZigZagConversion {
	public static void main(String argv[]) {
		Utils.check(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
		Utils.check(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
		Utils.check(convert("A", 1), "A");
	}

    public static String convert(String s, int numRows) {
    	if (s.length() <= numRows || numRows <= 1) {
			return s;
		}
    	int len = s.length();
    	List<StringBuilder> ls = new ArrayList<>(len);
    	for (int i = 0; i < len; i++) {
			ls.add(new StringBuilder(len/(numRows-1)));
		}
    	int row = 0, step = 1;
    	
    	for (int i = 0; i < len; i++) {
			if (row == 0) {
				step = 1;
			} else if (row == numRows-1) {
				step = -1;
			}
			ls.set(row, ls.get(row).append(s.charAt(i)));
			row += step;
		}

		StringBuilder result = new StringBuilder(len);
    	for (int i = 0; i < numRows; i++) {
			result.append(ls.get(i));
		}
		return result.toString();
    }
}
