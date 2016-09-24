package com.github.triploit.npp5.other;

import com.github.triploit.npp5.compiler.LCompiler;

public class CompileCode
{
	private LCompiler lc;
	
	public CompileCode(String code)
	{
		 lc = new LCompiler(code);
	}
	
	public void setCode(String c)
	{
		lc.setCode(c);
	}
	
	public void initStrings()
	{
		lc.addString("mov",    "_0d8dnBK34tv3vq3b2b673753nbzgu7hj5gftrJd9d8dgbaksj");
		lc.addString("add",    "_dmwjl4345trz55t6zeruzez5t4r65rzk88zbw67ard7gb");
		lc.addString("defi",   "ankadj4z6z7huj546ez5tu6zrte4w5e6rzuiwhdkwndknawkj_");
		lc.addString("defs",   "abd89baxtrg4eq23trerw45trzcu87w/Tgb8)TDh9_");
		lc.addString("div",    "_fr234e44rtt32rtw43egz5hrwe4tzuisa8u7r1e2dq2rr12");
		lc.addString("leq",    "_qr123ot687z8u6t7zd45rsw35setrhzdtjuzfq3fq");
		lc.addString("geq",    "_2qf2r6u7t6i85674e63wa5erfht6u7e4fq2r2");
		lc.addString("eq",     "_qf2fqetrhztjgmzku7t6i58e47w36segt2f2tf");
		lc.addString("neq",    "_q2tg28juuuuuuuuxdfcgbjzu7t65e4df3gerh");
		lc.addString("mod",    "_wafawfz678dgtrfh7zugfr6z5ezh4w3eftjna");
		lc.addString("mul",    "_z234t62t65rsdfxbgnjzu5retrsgf43gfbhw2");
		lc.addString("div",    "_5u7z62wrdhgfhjzuztaegsxfcgnvhgkzuiwht3rf3e");
		lc.addString("ddv",    "_dft5rh5zhfndgtsefdsgvbdhzte5345derhzzwz34");
		lc.addString("ddm",    "_6w344r3wz8nh8bb8vhnzvrp3thtio4tr5gzfs2");
		lc.addString("inp",    "_3tgfez54647zw5zh4f89sber8fz8oe7zr9p8webr6u556tg");
		lc.addString("end",    "_09naw9d6wabaw9f7wa67jf09n0h280eiiwovbhnui");
		lc.addString("prv",    "_436z73qweh4bvr78tzqw7896v837b59u735e6uhrz");
		lc.addString("rem",    "_45zhgwe43e5v6h2983rb9q2vn9b29v79q2vnz6ue54ez");
		lc.addString("gt", 	   "_w467z54hg3e22er0vrqn9z3rfb0jqvnvh705b47z345hzu");
		lc.addString("return", "_345zrer3hnvrq89vr7nq0236bvnqp902nv2zzu46565i5z");
		lc.addString("[n]",    "_89w7anq22vnq2v9070q29vnq2b9bn9v2btrvfqpu9f8235rfw5");
		lc.addString("say",    "_fn8e7ff0t7eg8zegvf8uhijfq5bh0ntzf0rfuj98n8fna8w");
		lc.addString(";",      "_fn0awnf7qd89vqhr8nfuinz070u9fzqr0ß7rfv209afa89wf9na");
		lc.addString("@",      "_n0af798qnzbmß908nzthjof0uq3u8hjtgf90awfba90w7bf0");
		lc.addString("{",      "_0nf7a9wq2rdfqrnzfh9m00ßm7qß7zhmfqtzbf9awnfß0aw8f9");
		lc.addString("}",      "_w70fa7nwq2rfzhvuoqm0jb74rhnzq09n8v8z88f9a0ßwfn0aw79b");
		lc.addString(" ",      "_nw0faqrfvnzm9q087rnfzh0viihdgztn0wf60fn7a90w7fn");
		lc.addString("\"",     "_2w3e45r5qrwfnz9e8r7gt83nvrg9097mt6zi7ri5u8etj");
		lc.addString(",",      "_w3zu487wzrfnqz98t89q7nbu9rzq78zhsrjrk44zu5hj5i");
	}
	
	public LCompiler getCompiler()
	{
		return lc;
	}
	
	public String decryptCode()
	{
		return lc.doDecrypt();
	}
	
	public String encryptCode()
	{
		return lc.doEncrypt();
	}
}
