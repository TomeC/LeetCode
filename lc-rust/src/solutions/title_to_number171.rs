use super::Solution;

#[allow(dead_code)]
impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        let mut row_count: i32 = 0;
        for c in column_title.chars() {
            row_count = row_count*26+(c as i32)-64;
        }
        return row_count;
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        assert!(Solution::title_to_number(String::from("A"))==1, 1);
        assert!(Solution::title_to_number(String::from("AB"))==28, 2);
        assert!(Solution::title_to_number(String::from("ZY"))==701, 3);
        println!("{}", Solution::title_to_number(String::from("ABC")));
        println!("over")
    }
}