package com.xiaoyu.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author yujiazhen
 * @description 读取目录信息
 * @date ${DATE}
 * @version 1.0
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter() {
    }

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File file, String name) {
        return pattern.matcher(name).matches();
    }

}

