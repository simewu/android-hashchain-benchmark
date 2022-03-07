sudo apt-get --purge autoremove solc -y
sudo snap remove solc

sudo add-apt-repository ppa:ethereum/ethereum
sudo apt-get update
sudo apt-get install solc

pip3 install solc-select
solc-select install 0.8.12
solc-select use 0.8.12