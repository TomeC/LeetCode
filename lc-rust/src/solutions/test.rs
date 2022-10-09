use super::Solution;

#[allow(dead_code)]
impl Solution {
    pub fn test() {
        let i = String::from("hello");
        println!("{}", i);
        let j = &i;
        println!("{}, {}", i, j);
    }
    pub fn show() {
        println!("---- show ok ----");
    }

}
#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        Solution::test();
    }
    #[test]
    fn show_test() {
        Solution::show();
    }
}