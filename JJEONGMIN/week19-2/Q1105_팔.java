public class Q1105_팔 {
    public static void main(String[] args) {
        // 로직 생각
        // L과 R이 주어지고, L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 8의 개수를 구하는 프로그램
        // L <= R <= 20억 (int 사용 가능)
        // 8이 고정으로 들어갈 수 밖에 없는 위치를 찾는다 -> 자리 수 별로 체크 큰 값 - 작은 값을 했을 때 8이 나올 수 있는지 여부 체크
        // 자리 수 만큼의 array를 만들고 각 자리 수 별로 true / false 체크를 해가며 로직 진행
        // 최후 array의 길이만큼 for문을 돌려 false인 값의 개수를 count
    }
}
