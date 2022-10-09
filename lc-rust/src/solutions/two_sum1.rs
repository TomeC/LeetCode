use super::Solution;

#[allow(dead_code)]
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut res: Vec<i32> = Vec::new();
        for (i, v) in nums.iter().enumerate() {
            for j in i+1..nums.len() {
                if v+nums[j] == target {
                    res.push(i as i32);
                    res.push(j as i32);
                    return res;
                }
            }
        }
        return res;
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        Solution::two_sum(vec!(2,7,11,15), 9);
    }
}