#include <expected>
#include <iostream>

std::expected<int, std::string> divide(int a, int b) {
    if (b == 0) return std::unexpected("Cannot divide by zero.");
    return a / b;
}

int main() {
    auto result = divide(10, 0);
    if (result) {
        std::cout << "Result: " << *result << std::endl;
    } else {
        std::cout << "Error: " << result.error() << std::endl;
    }
    return 0;
}
