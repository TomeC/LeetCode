use super::Solution;

#[allow(dead_code)]
impl Solution {
    pub fn convert_to_title(column_number: i32) -> String {
        let mut number:i32 = column_number;
        let mut result:String = String::new();
        while number > 26 {
            let remain:u8 = (number%26) as u8;
            
            number /= 26;
            if remain == 0 {
                result.insert(0, 'Z');
                number -= 1;
            } else {
                result.insert(0, (remain+64) as u8 as char);
            }
            println!("{}", result);
        }
        
        result.insert(0, (number+64) as u8 as char);
        println!("{}", result);
        return result;
    }
}

#[cfg(test)]
mod test {
    use super::Solution;

    #[test]
    fn convert_to_title_test() {
        assert_eq!(Solution::convert_to_title(52), String::from("AZ"));

        assert_eq!(Solution::convert_to_title(1), String::from("A"));
        assert_eq!(Solution::convert_to_title(26), String::from("Z"));
        assert_eq!(Solution::convert_to_title(28), String::from("AB"));
    
        assert_eq!(Solution::convert_to_title(701), String::from("ZY"));
        assert_eq!(Solution::convert_to_title(2147483647), String::from("FXSHRXW"));
        assert_eq!(Solution::convert_to_title(731), String::from("ABC"));
    }
    #[test]
    fn demo_test() {
        let mut data:String = String::from("A");
        data.push_str("B");
        data.insert_str(0, "X");
        println!("{}", data);
    }
}