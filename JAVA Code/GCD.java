// Division algorithm

// Iterative
private int GCD(int a, int b) {
    int temp = 0;
    while (b != 0) {
        temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}


// Recurrsion
private int gcd(int a, int b) {
    if (b == 0)    return a;
    return gcd(b, a % b);
}