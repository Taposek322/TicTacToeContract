// SPDX-License-Identifier: MIT
pragma solidity >=0.5.0;
import "hardhat/console.sol";
contract EmployeeSalaryContract
{
    address private owner;
    address[] private  addresses;

    struct EmployeeRecord {
        string name;
        uint age;
        string addr;
        uint amount;
    }

    mapping (address => EmployeeRecord) private employees;

    constructor() {
        owner = msg.sender;
    }

    function deposit() external payable {
        require(msg.value<=msg.sender.balance,"Error. You dont have this amount on your balance");
    }

     function getEmployeeNum() public view returns(uint _employeeNum)
    {
        return addresses.length;
    }

    function getEmploee() public view returns(EmployeeRecord memory emp){
        return employees[msg.sender];
    }

    function getOwnerAddr() public view returns(address _ownerAddress){
        return owner;
    }

    function getTotalReward() public  view  returns(uint _totalReward){
        return address(this).balance;
    }


    function getTotalPercentage() private view returns(uint _totalPercentage){
        uint tPerc = 0;
        for(uint i=0; i < addresses.length; i++)
        {
            tPerc += employees[addresses[i]].amount;
        }
        return tPerc;
    } 

    function registerEmployee(string memory _name, uint _age , uint _amount, string memory _addr) public
    {
        require(_amount<=100,"Error. Amount cant be greater than 100");
        uint totalPercentage = getTotalPercentage();
        bool exists = false;
        address existedAddr;

        for (uint i = 0; i < addresses.length; i++)
        {
            if (addresses[i] == msg.sender)
            {
                exists = true;
                existedAddr = addresses[i];
                break ;
            }
        }

        //Если уже зарегистрирован, то делаем поправку процента
        if(exists){
            totalPercentage-=employees[existedAddr].amount;
        }
        require(100-totalPercentage>=_amount,"Error. Total percentage can`b be greater than 100");
        employees[msg.sender] = EmployeeRecord(_name,_age,_addr,_amount);
        
        if (exists == false)
        {
            addresses.push(msg.sender);
        }
    }

    function payment() external payable 
    {
        require(msg.sender == owner,"Error. Only the owner can call this contrac function");

        uint balance = address(this).balance;

        for (uint i = 0; i < addresses.length; i++)
        {
            uint amount = (uint)(balance*employees[addresses[i]].amount/100);
            address payable reciever = payable(addresses[i]);
            reciever.transfer(amount);
        }
    }

}