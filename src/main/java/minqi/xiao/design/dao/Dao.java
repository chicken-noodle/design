package minqi.xiao.design.dao;

import minqi.xiao.design.model.Character;
import minqi.xiao.design.model.Picture;
import minqi.xiao.design.model.Poem;
import minqi.xiao.design.model.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao {

    //Word:查最大数
    @Select("select count(*) from memory_word")
    public int getWordNum();
    //Word：取值
    @Select("select word,word_mean,analysis,memory from memory_word where id = #{id}")
    public Word getWordById(Integer id);
    //Character:查最大值
    @Select("select count(*) from memory_character")
    public int getCharacterNum();
    //Character：取值
    @Select("select * from memory_character where id = #{id}")
    public Character getCharacterById(Integer id);
    //Poem：查最大值
    @Select("select count(*) from memory_poem")
    public int getPoemNum();
    //Poem：取值
    @Select("select * from memory_poem where id = #{id}")
    public Poem getPoemById(Integer id);

    //picture：查最大值
    @Select("select count(*) from memory_picture")
    public int getPictureNum();
    //picture：取值
    @Select("select * from memory_picture where id = #{id}")
    public Picture getPictureById(Integer id);
    //picture：插入
    @Insert("insert into memory_picture (uuid) value (#{uuid})")
    public void postPictureUUID(String uuid);



}
