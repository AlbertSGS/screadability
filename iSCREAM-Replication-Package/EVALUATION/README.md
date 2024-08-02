# iSCREAM - Evaluation 
To evaluate the tool, we extracted the source code of 2,186 Solidity smart contracts (see Dataset.zip file). To ensure that the tool can correctly compute metrics on functions of various sizes, from the 2,186 smart contracts, we selected 90 functions for manual verification. In particular, we first divided all the functions belonging to the 2,186 smart contracts into three categories: low (i.e., functions with less than 35 lines of code), medium (i.e., functions with a number of lines of code between 35 and 68), and high (i.e., functions having more than 68 lines of code). Then, we randomly selected 30 functions for each category and manually verified the correctness of the tool's outputs. In the following, for each category, we report a table indicating the selected functions.


### Low category:

|Solidity-File|Contract-Name|Function-Name|
|:--:|:--:|:--:|
|0x0389a06b028526b05966c287370bebefa0082176_Dividend.sol|Dividend|SetProfitAddr|
|0x0c24e3aa0fc411debf74f138674cf2066c2e0ace_FalconFarmer.sol|FalconFarmer|calculateTrade|
|0x11fc42be8b14aeecfc371af217c4648e6423fa60_POWHclone.sol|POWHclone|fund|
|0x15c1426677d49730a50fee58e50a10a0c13a6fce_HFTCrowdsale.sol|SafeMath|add|
|0x167cb3f2446f829eb327344b66e271d1a7efec9a_GandhiJi.sol|GandhiJi|disableInitialStage|
|0x19226ae123349c30df4b84d69531668cdb1050e6_TheEternal.sol|TheEternal|restart|
|0x22a1ed2f03206be150ede2a7ffa909f7be033d99_AuthenticationManager.sol|XWinToken|totalSupply|
|0x23d23d8f243e57d0b924bff3a3191078af325101_BokkyPooBahsDateTimeContract.sol|BokkyPooBahsDateTimeContract|diffMinutes|
|0x266be180f1bdda078b677c5d1c050268929f0da3_CASINO_301201.sol|CASINO_301201|transferFrom|
|0x36f6a1353a3e1c008782e86bfe551c6f8b8c3370_Shadow3D.sol|Shadow3D|()|
|0x41451E8E7Fd5B9A4F8176CCF1a0DB2B68Abc77fb_FART.sol|FART|calculateEthereumReceived|
|0x48535d9d836fb6323dc038b6a82ac407f66f58b0_AZTCrowdsale.sol|AZTCrowdsale|sendToken|
|0x4d48ee87ab535833fdd79c7d1c4aac3c7c304b13_Pomda.sol|Pomda|ethereumToTokens_|
|0x529aea548fb57dc1eefa4f02e1a317d41a305456_VAI.sol|VAI|transferFrom|
|0x5d1f222108e1a27f95c596f5df289e61068537ab_MoonDustDividends.sol|MoonDustDividends|sqrt|
|0x6013b9e512c5a7b8e03a5e1ebd6231cd195d50a7_RBC.sol|TokenERC20|approve|
|0x698e0209955846a1dd8782a1d107f23ee4255476_OneToken.sol|StandardToken|allowance|
|0x735906d7ab237eeea06f4af86795bb4e0ec199e0_BLITZ_QUIZ.sol|BLITZ_QUIZ|NewQuestion|
|0x821cf456f64bd466c89cae3a74ae5173633d1992_Wicflight.sol|Wicflight|getInsurancesCount|
|0xa7620c421d29db2bb991cd603a725b960e927ced_Hash.sol|Hash|()|
|0xa8ab3820eb5a5c1eb77d9ded7ee95d5b5ce63357_Zaynix.sol|Zaynix|sell|
|0xaf03be0017d0ba1c924b6c3de17e18d1be74b02a_InfinityHourglass.sol|SafeMath|mul|
|0xb44d36a18b18015c546f5efa37bb1e3db5f24063_FishFarmer.sol|FishFarmer|calculateEggBuy|
|0xB9e050eE5B033CBb0A5240EAf3E9DF45C07e354f_Mmmm.sol|Mmmm|canTransferFrom|
|0xbee097cc2885a36318cfd0cf3d6cbd4c06a3f79d_SiriusLendingNetwork.sol|SiriusLendingNetwork|_transfer|
|0xc7e454770433c071dd1863eeB27FB7e1adBD3361_RESPAY.sol|RESPAY|Play|
|0xD4737858Dd8eb9842CD0696171b781525B56086f_NoteChain.sol|NoteChain|onlyOwner|
|0xd4bc389b96450aeae23662bf7e5e4fdadebc98c8_MilliSetCoin.sol|MilliSetCoin|transfer|
|0xF34E5D61d894899B912e56368De3D109cE7427f4_PsyMultiSig.sol|PsyMultiSig|getConfirmationCount|
|0xf4cc5058f6eda259230438abd417d4afc39335d2_SingleSourceAuthority.sol|SingleSourceAuthority|SingleSourceAuthority|

### Medium category:
|Solidity-File|Contract-Name|Function-Name|
|:--:|:--:|:--:|
|0x0e0a86c97a07856d68bf3387aeb9430dbab93245_InterbetCore.sol|InterbetCore|takeBet|
|0x167cb3f2446f829eb327344b66e271d1a7efec9a_GandhiJi.sol|GandhiJi|purchaseTokens|
|0x2044c97717a622b4d9462329db2497e69201623a_Lottery4.sol|Lottery4|buyTickets|
|0x2282a327a9293895cacbce617b194e6031d6ffa4_JustCoin.sol|JustCoin|buy|
|0x23d8E1DA32bba8e3A6B88d51BE158CDfFEff7FCC_EMPresale.sol|EMPresale|buySale|
|0x29638d9c4ee1cf25397de06a1c849721a692d143_ReternalETH.sol|ReternalETH|createDeposit|
|0x2a92f24bfad42b04cfe5c000be404c2a84ca5b71_CryptoSuperGirlfriend.sol|CryptoSuperGirlfriend|buy|
|0x30f5426f1532562ae8586105cc608130f845536d_NameFilter.sol|PlayerBook|registerNameXname|
|0x33f00114d5aca3dee03189d4ed9d4f886dad84b0_PonziToken.sol|PonziToken|buy|
|0x41451E8E7Fd5B9A4F8176CCF1a0DB2B68Abc77fb_FART.sol|FART|sell|
|0x4ba72f0f8dad13709ee28a992869e79d0fe47030_EtheremonTrade.sol|EtheremonTrade|release|
|0x4e89a683dade995736457bde623e75f5840c2d34_SHA1Digest.sol|BytesUtils|compare|
|0x57cff17810be242bc4760c03cd5bcc6ec0879470_POWMlite.sol|POWMlite|transfer|
|0x58a11a4445adc8384ccb69935162af2ca5ae7f63_Ethervote.sol|Ethervote|bet|
|0x5c976e71bb27538bddb0ed399be1722c6745bcb6_ProofOfKennyCoin.sol|ProofOfKennyCoin|transfer|
|0x6238972611f7933c6c0919c54447e2bac86f96e7_CopaDelCrypto.sol|CopaDelCrypto|VerifyPublishedResults|
|0x6d6db51e3e4838369676508ce25db64f4ca7e5e4_EtherX.sol|EtherX|transfer|
|0x748c6ed3f78f5f06ceb76834f195d3a05b7d628a_POWH33.sol|POWH33|transfer|
|0x820d413cb4c38d3b328cefc3e661072102d3898e_KALIFORCOINICO.sol|KALIFORCOINICO|()|
|0x879716da78A75a44bdfa8F038ce875f99586940a_DecenterHackathon.sol|DecenterHackathon|payoutPrizes|
|0x9A0991fc223dFFE420e08f15b88a593a3b8D44B8_Danku_demo.sol|Danku_demo|get_submission_id|
|0xb8199a71c17d392298e3346d3fd675bfd8e0b661_HyperPonzi.sol|HyperPonzi|sell|
|0xc0d72D45CcA854e0F2fE3Cd2D4BAb91E772fE4C0_Pixereum.sol|Pixereum|buyPixel|
|0xc3c94e2d9a33ab18d5578bd63dfdaa3e0ea74a49_PyramidGame.sol|PyramidGame|placeBlock|
|0xc5936b4e458c60f887a4f17d05d2f8162976e012_ProfitChain.sol|ProfitChain|payAllInvitors|
|0xc5936b4e458c60f887a4f17d05d2f8162976e012_ProfitChain.sol|ProfitChain|newGroup|
|0xD4EaE5676321b4b8289C39C6233561FCD978575a_Game35.sol|Game35|addIn|
|0xe34d036fa2f3b28dd9b842453288786ec9ddfcb0_Game31.sol|Game31|addIn|
|0xf06ab3e6a33f805cf7cb448db82c8cd9c109a862_POCG.sol|POCG|transfer|
|0xf2665a78aec490c1bb5ab3e0927050e1857f70f9_ChefICO.sol|ChefICO|()|

### High category:
|Solidity-File| Contract-Name|Function-Name|
|:--:|:--:|:--:|
|0x00efd61b0d94ccd82f3922d26efdd3ed9859081a_EthPyramid.sol|EthPyramid|reinvestDividends|
|0x05bc1d3454405d4767960efeb3cec216a0dd15f3_POCN.sol|POCN|purchaseTokens|
|0x06d66e857dd5fc55cb9fa29fa125a0b35fa63c18_JOLDEAME.sol|JOLDEAME|purchaseTokens|
|0x1403f1f45a95bae5905c6271ed779af786ba7984_POMW1.sol|POMW1|purchaseTokens|
|0x18420e17f0ee1b32d1174f673c7eaa946a180b63_StrongHold.sol|StrongHold|purchaseTokens|
|0x19cc1d132001b9b4414866281e2bb31102177330_UnKoin.sol|UnKoin|purchaseTokens|
|0x20a35ada16321d18ba2e72bd5fe81bc23515dbd9_ProofOfVerifiedContract.sol|ProofOfVerifiedContract|purchaseTokens|
|0x20c6c51edfb707f8965bb7caafc77372978eff10_ProofOfSheepM.sol|ProofOfSheepM|purchaseTokens|
|0x2aac6e4eb55d57f2a08d16d5000cfab7cebb4819_SHIT.sol|SHIT|purchaseTokens|
|0x364b22cf5dc5b2171c379fec513851bb263c1c6c_TeamManager.sol|MSFun|multiSig|
|0x3dc17F140E6a01F99ea3123cdcB4aEA3a85E8C79_Helios.sol|Helios|purchaseTokens|
|0x406d7401f451ee9d3a04652102aaf923c59f64e9_Elephant.sol|Elephant|purchaseTokens|
|0x43bfa1fd18fce2a533fe833ee5b132052369984c_ProofOfWeakHandsClassic.sol|ProofOfWeakHandsClassic|purchaseTokens|
|0x4d48ee87ab535833fdd79c7d1c4aac3c7c304b13_Pomda.sol|Pomda|purchaseTokens|
|0x51da145cd7b6e6bd8b334d6a5e663dee1d8937fa_Vitaluck.sol|Vitaluck|Play|
|0x629540f0955778be6b7165a602f9f25714be234a_AviciiCoin.sol|AviciiCoin|purchaseTokens|
|0x645f0c9695f2b970e623ae29538fdb1a67bd6b6e__8thereum.sol|_8thereum|purchaseTokens|
|0x6a40f8b2c7e6eb5bacbd52bc055e230d00168669_CharlieCoin.sol|CharlieCoin|purchaseTokens|
|0x6bacca3cce57a46fd0822df7c07afbf9d81d96d9_Jiggs.sol|Jiggs|purchaseTokens|
|0x6e692023289738afd6ec4a89bf048c5fbe2db884_OpenPoWH.sol|OpenPoWH|reinvestDividends|
|0x77586904ebeee8f117e46433b8863879d1cbd6f1_ProofOfNoSnipers.sol|ProofOfNoSnipers|purchaseTokens|
|0x8c79b780fa39e183C9eA25f70d1351161f86594e_shrimpyramid.sol|shrimpyramid|purchaseTokens|
|0x906d7b0bae2ae1aca8c5afdf2812d7f8dd999ebe_ETHDividends.sol|ETHDividends|reinvestDividends|
|0xa572e356fe636db853f0d55493f2f866f0558cde_POWH1337.sol|POWH1337|purchaseTokens|
|0xb447aa90c9aab424dba4c08b251d4b37f61a8392_EtherSpike.sol|EtherSpike|reinvestDividends|
|0xc7821b9e6cc3d318fa4b5916c00e7106aae919f4_ProofOfDoge.sol|ProofOfDoge|purchaseTokens|
|0xcbC07bff89d87280047a49c902B48C7258F65829_ProofOfSecret.sol|ProofOfSecret|purchaseTokens|
|0xcd488E9fC7392413C2925C1b0Da905aDFB49a500_FuckYouKenny.sol|FuckYouKenny|purchaseTokens|
|0xd31acfbbed78a56578a56ba61648e87e4b466e48_GOLDENRATIO.sol|GOLDENRATIO|purchaseTokens|
|0xf68000048048205cfa55e23bedfe0378401f3027_ProofOfIdiot.sol|ProofOfIdiot|purchaseTokens|
