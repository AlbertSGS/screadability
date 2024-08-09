pragma solidity ^0.8.0;

contract SecureReentrancy {
    mapping(address => uint256) private balances;

    // Function to safely withdraw funds
    function withdraw(uint256 amount) public {
        require(balances[msg.sender] >= amount, "Insufficient balance");

        // Update balance before making external call to prevent reentrancy
        balances[msg.sender] -= amount;

        // Use transfer() or call() safely to avoid reentrancy
        (bool success, ) = msg.sender.call{value: amount}("");
        require(success, "Transfer failed");
    }

    function deposit() public payable {
        balances[msg.sender] += msg.value;
    }
}


