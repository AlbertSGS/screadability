pragma solidity ^0.8.0;

contract UnreadableReentrancy {
    mapping(address => uint256) private balances;

    function withdraw(uint256 amount) public {
        if (balances[msg.sender] >= amount) {
            msg.sender.call.value(amount)("");
            balances[msg.sender] -= amount;
        }
    }

    function deposit() public payable {
        balances[msg.sender] += msg.value;
    }
}




